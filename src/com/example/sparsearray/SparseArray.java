package com.example.sparsearray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author yeye
 * @date 2022/10/5  9:51
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //定义数组存储文件路径
        String filename = "D:\\project\\DataStructures\\chessMain.txt";

        //创建一个原始的二维数组 11 * 11
        // 0表示没有棋子，1表示黑子， 2表示蓝子
         int row = 11;
         int col = 11;
         int[][] chessArr1 = new int[row][col];
         chessArr1[1][2] = 1;
         chessArr1[2][3] = 2;
         chessArr1[4][4] = 1;

        //遍历输出二维数组
        System.out.println("原始二维数组");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转换成稀疏数组
        //遍历二维数组，得到有效数据sum
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }

        System.out.println("sum=" + sum);
        //根据sum创建一个稀疏数组 sparseArr = int[sum+1][3]
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;
        //遍历二维数据将有效值赋值到稀疏数组中
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(chessArr1[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    
                    sparseArr[count][2] = chessArr1[i][j];
                }

            }
        }
        //遍历稀疏数组，打印结果
        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        File file = new File(filename);
        if(!file.exists()){
            file.createNewFile();

        }





        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), StandardCharsets.UTF_8));
        StringBuffer stringBuffer = new StringBuffer();
        for (int[] rows : sparseArr) {
            for (int data : rows) {
                stringBuffer.append(data).append("\t");
            }
            stringBuffer.append("\n");
            writer.write(stringBuffer.toString());
            writer.flush();
            stringBuffer = new StringBuffer();
        }
        writer.flush();      //清除缓冲区
        writer.close();

        //将chessMain.txt 中的数据输入到程序,并将输入的数据转化为稀疏数组
        int[][] sparseArr2 = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = "";
        int index = 0;
        while ((line = reader.readLine()) != null){
            String[] strArr = line.split("\t");
            if(index == 0){
                sparseArr2 = new int[Integer.parseInt(strArr[2]) + 1][3];
            }else {
                for (int i = 0; i < strArr.length; i++) {
                    sparseArr2[index][i] = Integer.parseInt(strArr[i]);
                }
            }
            index ++;
        }
        reader.close();

        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < Objects.requireNonNull(sparseArr2).length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组 转成  二维数组
        //先读取稀疏数组的第一行数据，根据第一行数据创建二维数组
        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        //遍历读取稀疏数组后几行，将值赋予二维数组
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        System.out.println("还原得到的二维数组为：");
        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
