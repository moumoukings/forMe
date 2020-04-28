package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 从text中读取对应数据
 *
 * @author zhangzichen
 * @date 2020/04/26 9:44
 */
public class ReadString {
    public static void main(String[] args) {
        String idNum = "4311270044";
        String txtPath = "g:\\data.txt";
        String result = getMatchLine(txtPath, idNum);
        if (result == null) {
            System.out.println("不存在身份证号为" + idNum + "的信息。");
        } else {
            System.out.println("查询成功，身份证号为" + idNum + "的信息如下：");
            System.out.println(result);
        }
    }

    /**
     * @param txtPath 文件路径
     * @param idNumber 匹配字符串
     * @return
     */
    private static String getMatchLine(String txtPath,String idNumber){
        String result = null;
        try {
            FileReader fr = new FileReader(new File(txtPath));
            BufferedReader br = new BufferedReader(fr);
            String readLine = br.readLine();
            while (readLine != null){
                if(readLine.contains(idNumber)){
                    result = readLine;
                    break;
                }else {
                    readLine = br.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
