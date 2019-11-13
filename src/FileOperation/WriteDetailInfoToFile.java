package FileOperation;

import DataDefinition.FilmDetailData;
import DataDefinition.FilmListData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class WriteDetailInfoToFile {
    //获取当前的目录
    public String GetCurrentPath(){
        File directory=new File(".");
        String path="";
        try {
            path=directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    //在目录中创建文件夹
    public String MakeFolder(String path,String folder_name){
        String folder_path=path+"/"+folder_name;
        File folder=new File(folder_path);
        if(!folder.exists())
            folder.mkdir();
        return folder_path;
    }

    //写入信息
    public void WriteDetailContent(FilmDetailData fdd, String path,String file_name) {
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(path+"/"+file_name));
            DownloadFile df=new DownloadFile();

            bw.write("标题 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("发布时间 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("导演 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("编剧 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("主演 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("类型 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("制片国家/地区 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("语言 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("上映日期 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("片长 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("又名 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("IMDb链接 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("豆瓣评分 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("评价次数 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("5星评价所占比例 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("4星评价所占比例 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("3星评价所占比例 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("2星评价所占比例 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("1星评价所占比例 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("剧情简介 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("图片链接 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("网址 : "+fdd.getTitle()+System.getProperty("line.separator"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
