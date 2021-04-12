package epsiode2;

/**
 * 判断字符串是不是合法的ipv4地址
 *
 * @author zhangzichen
 * @date 2021/04/12 11:08
 */
public class AchieveStringJudje {

    public static void main(String[] args) {
        String ip = "23.131.234.88";
        //校验字符串
        System.out.println(checkIp(ip));
        System.out.println(checkIp2(ip));
    }

    /**
     * 校验IP
     *
     * @param ip
     */
    private static boolean checkIp(String ip) {
        //需要转译
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            try {
                int parseInt = Integer.parseInt(s);
                if (parseInt > 255 || parseInt < 0) {
                    return false;
                }
                if (!s.equals("0") && s.startsWith("0")) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIp2(String ip) {
        //需要转译
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        String reg = "\\d||[1-9]\\d{1,2}";
        for (String s : split) {
            try {
                if (!s.matches(reg) || Integer.parseInt(s) > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}
