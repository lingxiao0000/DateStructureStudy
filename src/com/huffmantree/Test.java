package com.huffmantree;

/**
 * 赫夫曼树的测试
 *
 * @author Lingxiao
 * @date 2023/4/21 17:32
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.create(array);
        huffmanTree.preOrder();
    }
}
