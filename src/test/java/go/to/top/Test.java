package go.to.top;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\lishangang\\Desktop\\abc.txt")));
			String line;
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			while ((line = br.readLine()) != null) {
				String skuId = line.split(",")[0].trim();
				String brandCode = line.split(",")[1].trim();
				if (map.containsKey(brandCode)) {
					map.get(brandCode).add(skuId);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(skuId);
					map.put(brandCode, list);
				}
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\lishangang\\Desktop\\abc2.txt")));
			for (String key : map.keySet()) {
				List<String> list = map.get(key);
				StringBuffer heihei = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					heihei.append("'").append(list.get(i)).append("',");
					if ((i + 1) % 500 == 0) {
						heihei = heihei.deleteCharAt(heihei.length() - 1);
						bw.append("update base_sku_info set brand = '" + key + "' where sku_id in (" + heihei.toString() + ");\r\n");
						bw.flush();
						heihei = new StringBuffer();
					}
				}
				if (heihei.length() > 0) {
					heihei = heihei.deleteCharAt(heihei.length() - 1);
					bw.append("update base_sku_info set brand = '" + key + "' where sku_id in (" + heihei.toString() + ");\r\n");
					bw.flush();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
