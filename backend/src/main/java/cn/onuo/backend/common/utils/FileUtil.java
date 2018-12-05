package cn.onuo.backend.common.utils;

import org.json.JSONObject;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IDEA
 * author:Yanze
 * Date:2018/7/2
 * Time:15:52
 */
public class FileUtil {


    /**
     * 存储图片到指定文件夹
     * @param savePath
     * @param files
     * @return
     * @throws Exception
     */
    public static String[] SavePhotos(String savePath,String[] files) throws Exception {

        //存 图片的存储路径
        String[] urls = new String[files.length];

        if(files==null||files.length==0){
            return null;
        }

        String data="";
        String dataprefix="";

        for(int i=0;i<files.length;i++){
            String file = files[i];
            String[] str=file.split("base64,");
            if(str==null||str.length!=2){
                return null;
            }
            dataprefix=str[0];
            data=str[1];
            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataprefix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataprefix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataprefix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataprefix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                throw new Exception("上传图片格式不合法");
            }

            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            //FileUtils.writeByteArrayToFile(new File(savepath+System.currentTimeMillis()+suffix), bs);
            String timeStr = String.valueOf(System.currentTimeMillis());
            FileOutputStream out=new FileOutputStream(new File(savePath+timeStr+suffix));
            urls[i] = "/Images/"+timeStr+suffix;
            out.write(bs);
            out.flush();
            out.close();
        }

        return urls;
    }


    /**
     * 存储视频到指定文件夹
     * @param vediosavePath
     * @param file
     * @return
     */
    public static String SaveVedios(String vediosavePath,MultipartFile file){

        if (!file.isEmpty()) {
            try {

                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(vediosavePath+file.getOriginalFilename()))
                );
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return "/Vedios/"+file.getOriginalFilename();
    }



    /**
     * 将 MultipartFile 转换成 file
     * @param file
     * @return
     */
    public static File convert(MultipartFile file)
    {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convFile;
    }



//    public static IDCardInfo getByJson(String jsonResult){
//        HashMap map = new HashMap<String,String>();
//        IDCardInfo idCardInfo = new IDCardInfo();
//
//        try {
//            JSONObject jsonObject = new JSONObject(jsonResult);
//            JSONObject words_result= jsonObject.getJSONObject("words_result");
//            Iterator<String> it = words_result.keys();
//            while (it.hasNext()){
//                String key = it.next();
//                JSONObject result = words_result.getJSONObject(key);
//                String value=result.getString("words");
//                switch (key){
//                    case "姓名":
//                        map.put("name",value);
//                        idCardInfo.setName(value);
//                        break;
//                    case "民族":
//                        map.put("nation",value);
//                        idCardInfo.setNation(value);
//                        break;
//                    case "住址":
//                        map.put("address",value);
//                        idCardInfo.setAddress(value);
//                        break;
//                    case "公民身份号码":
//                        map.put("IDCard",value);
//                        idCardInfo.setIDCard(value);
//                        break;
//                    case "出生":
//                        map.put("Birth",value);
//                        idCardInfo.setBirth(value);
//                        break;
//                    case "性别":
//                        map.put("sex",value);
//                        idCardInfo.setSex(value);
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return idCardInfo;
//    }



}
