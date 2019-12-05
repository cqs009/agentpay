package com.touchme.agentpay.common.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @program: SignUtil
 * @description: 自定义验签工具类
 * @author: chen qing shan
 * @create: 2019/12/4 13:56
 */
public class SignUtil {

    public static String makeSign(String jsonStr, String md5Key) {
        Map params = jsonToMap(jsonStr);
        String preStr = buildSignString(params);
        String text = preStr + md5Key;
        return DigestUtil.md5Hex(getContentBytes(text, "UTF-8")).toUpperCase();
    }

    public static String makeSign(JSONObject json, String md5Key) {
        Map params = jsonToMap(json);
        String preStr = buildSignString(params);
        String text = preStr + md5Key;
        return DigestUtil.md5Hex(getContentBytes(text, "UTF-8")).toUpperCase();
    }

    public static boolean checkSign(String jsonStr, String md5Key) {
        return StrUtil.isNotBlank(jsonStr) && checkSign(md5Key, jsonToMap(jsonStr));
    }

    public static boolean checkSign(JSONObject json, String md5Key) {
        return !JSONUtil.isNull(json) && checkSign(md5Key, jsonToMap(json));
    }

    public static boolean checkSign(HttpServletRequest request, String md5Key) {
        Map params = null;

        try {
            params = getRequestParams(request);
        } catch (Exception arg3) {
            return false;
        }

        return checkSign(md5Key, params);
    }

    private static String makeSign(String md5Key, Map<String, String> params) {
        String preStr = buildSignString(params);
        String text = preStr + md5Key;
        return DigestUtil.md5Hex(getContentBytes(text, "UTF-8")).toUpperCase();
    }

    private static boolean checkSign(String md5Key, Map<String, String> params) {
        String sign = (String) params.get("sign");
        if (StrUtil.isBlank(sign)) {
            return false;
        } else {
            String signV = makeSign(md5Key, params);
            return StrUtil.equalsIgnoreCase(sign, signV);
        }
    }

    public static Map<String, String> jsonToMap(String msg) {
        JSONObject json = new JSONObject(msg,false,false);
        return jsonToMap(json);
    }

    public static Map<String, String> jsonToMap(JSONObject json) {
        HashMap map = new HashMap();
        Iterator arg1 = json.keySet().iterator();

        while (arg1.hasNext()) {
            Object key = arg1.next();
            String value = (String) json.get((String) key);
            map.put((String) key, value);
        }

        return map;
    }

    private static String buildSignString(Map<String, String> params) {
        return buildSignString(params, false);
    }

    private static String buildSignString(Map<String, String> params, boolean isAllParams) {
        if (params != null && params.size() != 0) {
            ArrayList keys = new ArrayList(params.size());
            Iterator buf = params.keySet().iterator();

            while (true) {
                String i;
                do {
                    do {
                        if (!buf.hasNext()) {
                            Collections.sort(keys);
                            StringBuilder arg6 = new StringBuilder();

                            for (int arg7 = 0; arg7 < keys.size(); ++arg7) {
                                String key = (String) keys.get(arg7);
                                String value = (String) params.get(key);
                                if (arg7 == keys.size() - 1) {
                                    arg6.append(key + "=" + value);
                                } else {
                                    arg6.append(key + "=" + value + "&");
                                }
                            }

                            return arg6.toString();
                        }

                        i = (String) buf.next();
                    } while ("sign".equals(i));
                } while (StrUtil.isEmpty((CharSequence) params.get(i)) && !isAllParams);

                keys.add(i);
            }
        } else {
            return "";
        }
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset != null && !"".equals(charset)) {
            try {
                return content.getBytes(charset);
            } catch (UnsupportedEncodingException arg2) {
                throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
            }
        } else {
            return content.getBytes();
        }
    }

    private static Map<String, String> getRequestParams(HttpServletRequest request) throws Exception {
        Map params = request.getParameterMap();
        HashMap params2 = new HashMap();
        Iterator arg2 = params.keySet().iterator();

        while (arg2.hasNext()) {
            String key = (String) arg2.next();
            String[] values = (String[]) params.get(key);
            if (values.length > 0) {
                params2.put(key, URLDecoder.decode(values[0], "UTF-8"));
            }
        }

        return params2;
    }
}
