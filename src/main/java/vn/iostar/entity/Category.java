package vn.iostar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Category() {
	}

	/*
	 * Trường khóa chính @Id Tham chiếu đến cột CategoryId
	 */
	@Id
	@GeneratedValue
	@Column(name="CategoryId")
	private int categoryId;
	
	@Column(name="Categoryname", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String categoryname;
	
	@Column(name="Images", columnDefinition = "NVARCHAR(500) NULL")
	private String images;
	
	@Column(name="Status")
	private int status;
	
	/*
	 * @OneToMany(mappedBy="category") là một annotation trong Hibernate và JPA
	 * (Java Persistence API) được sử dụng để thiết lập mối quan hệ một-nhiều giữa
	 * hai thực thể. Trong trường hợp này, nó chỉ định rằng một thực thể Category có
	 * thể liên kết với nhiều thực thể Video.
	 */
	/* Quản lý các Video thuộc về một danh mục cụ thể */
	@OneToMany(mappedBy="category")
	private List<Video> videos;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	
}
