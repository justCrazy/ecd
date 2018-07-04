package com.ecd.tool;

import com.alibaba.fastjson.JSON;
import com.ecd.pojo.Event;
import com.ecd.pojo.Notice;
import com.ecd.pojo.Person;
import com.ecd.pojo.VO;

public class test {
	public static void main(String[] args) throws Exception {

		// TimeGet.getTime();
		// UUIDGet.getUUID();
		// System.out.println(UUIDGet.getUUID());
//		String vText = VerifyCode.getVText();
		// String vText2 = "123";
		// String vText = "123";
		// System.out.println(vText);
		// if (vText2==vText) {
		// System.out.println("相等");
		// } else {
		// System.out.println("不同");
		// }
//		MessageSend.sendMessage(vText, "1062646428@qq.com");
		
		Person per = new Person();
		Event event = new Event();
		Notice notice = new Notice();
		VO vo = new VO(per,event,notice);
		System.out.println(vo);
		System.out.println(JSON.toJSONString(vo));
	}
}
