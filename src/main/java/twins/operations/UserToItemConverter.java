package twins.operations;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import twins.data.ItemEntity;
import twins.data.UserEntity;
import twins.logic.OperationEntityConverter;
import twins.logic.UserItemConverter;

@Component
public class UserToItemConverter implements UserItemConverter{
	private String space;
	private String id;
	private OperationEntityConverter converter;
	
	public UserToItemConverter() {
		this.id = "Id";
	}
	
	public String getSpace() {
		return space;
	}

	@Value("${spring.application.name:2021b.iftach.avraham}")
	public void setSpace(String space) {
		this.space = space;
	}
	
	@Autowired
	public void setConverter(OperationEntityConverter converter) {
		this.converter = converter;
	}
	
	@Override
	public ItemEntity UserToItem(UserEntity user, String type) {	
		ItemEntity item = new ItemEntity();
		
		String newId = this.space + "_" + UUID.randomUUID().toString();
		item.setItemSpace(this.space);
		item.setId(newId);
		item.setType(type); 	
		item.setName(user.getEmailSpace().split("@@")[0]);
		item.setActive(true);
		item.setTimestamp(new Date());
		item.setUserEmail(user.getEmailSpace().split("@@")[0]);
		item.setUserSpace(user.getEmailSpace().split("@@")[1]);
		item.setLat(0);
		item.setLng(0);
		Map<String, Object> json = new HashMap<>();
		json.put(this.id, user.getEmailSpace());
		item.setItemAttributes(this.converter.fromMapToJson(json));
		
		return item;
	}

}
