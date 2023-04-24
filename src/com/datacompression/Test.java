package com.datacompression;

import java.util.Arrays;
import java.util.Map;

/**
 * 使用赫夫曼树进行数据压缩的测试
 *
 * @author Lingxiao
 * @date 2023/4/23 14:45
 */
public class Test {

    public static void main(String[] args) {

        String s = "i like like a java do you like a java!";
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.create(s);
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(huffmanTree.getMap());
        System.out.println("~~~~~~~~~~~~~~");
        huffmanTree.preOrderLeaf();
        System.out.println("~~~~~~~~~~~~~~~~");
        huffmanTree.createKeyMap();
        Map<Character, StringBuilder> keyMap = huffmanTree.getKeyMap();
        System.out.println(keyMap);

        System.out.println("接下来进行字符编码");
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(keyMap.get(c));
        }
        System.out.println(stringBuilder);


        System.out.println("接下来数据压缩");
        byte[] zip = zip(stringBuilder);
        System.out.println(Arrays.toString(zip));
        System.out.println("原本的字符串字节数组长度:" + s.getBytes().length);
        System.out.println("压缩后的字节数组长度:" + zip.length);

    }

    public static byte[] zip(StringBuilder sb) {
        // 首先计算字节码长度
        int length;
        if (sb.length() % 8 == 0) {
            length = sb.length() / 8;
        } else {
            length = sb.length() / 8 + 1;
        }

        byte[] bytes = new byte[length];
        // 接下来8位一组进行压缩
        for (int i = 0; i < length; i++) {
            String bytString;// 要转化为byte的字符段
            if ((i + 1) * 8 < sb.length()) {
                bytString = sb.substring(i * 8, (i + 1) * 8);
            } else {
                bytString = sb.substring(i * 8);
            }
            byte b = (byte) Integer.parseInt(bytString, 2);
            bytes[i] = b;
        }
        return bytes;
    }
}
