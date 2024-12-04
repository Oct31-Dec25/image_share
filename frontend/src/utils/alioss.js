// var OSS = require('ali-oss');
import OSS from "ali-oss";
export function client() {
  var client = new OSS({
    endpoint: "oss-cn-guangzhou.aliyuncs.com", //填写Bucket所在地域
    accessKeyId: "LTAI5tHYr8ey9N5cZPrT159h",
    accessKeySecret: "GYeAkL4Xvt806RYSXpPLK0cMitYQD8",
    bucket: "images-share-seig", // 填写Bucket名称。
  }); //后端提供数据
  return client;
}
/**
 * 生成随机文件名称
 * 规则八位随机字符，加下划线连接时间戳
 */
export const getFileNameUUID = () => {
  function rx() {
    return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
  }
  return `${+new Date()}_${rx()}${rx()}`;
};
