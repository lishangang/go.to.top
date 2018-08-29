package go.to.top.readLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Test {
	

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\lishangang\\Desktop\\123.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\lishangang\\Desktop\\123-2.txt")));
			String line = null;
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			while((line = br.readLine()) != null) {
				String skuId = line.split(",")[0].trim();
				String unit = line.split(",")[1].trim();
				List<String> list = map.get(unit);
				if (list == null) {
					list = new ArrayList<String>();
					map.put(unit, list);
				}
				list.add(skuId);
			}
			for (String key : map.keySet()) {
				List<String> list = map.get(key);
				StringBuilder sql = new StringBuilder("UPDATE base_sku_info SET unit= '" + key + "' where sku_id in (");
				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					if ((i+1) % 1000 == 0) {
						bw.newLine();
						bw.write(StringUtils.substringBeforeLast(sql.toString(), ",") + ");");
						sql = new StringBuilder("UPDATE base_sku_info SET unit= '" + key + "' where sku_id in (");
						flag = false;
					} else {
						flag = true;
						sql.append("'" + list.get(i) + "',");
					}
				}
				if (flag) {
					bw.newLine();
					bw.write(StringUtils.substringBeforeLast(sql.toString(), ",") + ");");
				}
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
