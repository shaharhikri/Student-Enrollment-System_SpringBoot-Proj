package twins.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="ITEMS")
public class ItemEntity {
	private String itemSpace;
	private String id;
	private String type;
	private String name;
	private boolean active;
	private Date timestamp;
	private String userSpace;
	private String userEmail;
	private double lat, lng;
	private String itemAttributes;
	
	private Set<ItemEntity> children;

	private Set<ItemEntity> parents;


	
	public ItemEntity() { 
		this.children = new HashSet<ItemEntity>();

		this.parents = new HashSet<ItemEntity>();
	}

	public String getItemSpace() {
		return itemSpace;
	}

	public void setItemSpace(String itemSpace) {
		this.itemSpace = itemSpace;
	}
	
	@Id
	@Column(name="ITEM_ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ITEM_TIMESTAMP")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserSpace() {
		return userSpace;
	}

	public void setUserSpace(String userSpace) {
		this.userSpace = userSpace;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	@Lob
	public String getItemAttributes() {
		return itemAttributes;
	}

	public void setItemAttributes(String itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Items_Many2Many",
		joinColumns={@JoinColumn(name="parent")},
		inverseJoinColumns={@JoinColumn(name="child")})
	public Set<ItemEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<ItemEntity> children) {
		this.children = children;
	}
	
	public void addChild (ItemEntity child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public void setParents(Set<ItemEntity> parents) {
		this.parents = parents;
	}

	@ManyToMany(mappedBy="children")
	public Set<ItemEntity> getParents() {
		return this.parents;
	}
	

	public void setParent(ItemEntity parent) {
		this.parents.add(parent);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userSpace == null) ? 0 : userSpace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEntity other = (ItemEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userSpace == null) {
			if (other.userSpace != null)
				return false;
		} else if (!userSpace.equals(other.userSpace))
			return false;
		return true;
	}
	
	
	
	
}
