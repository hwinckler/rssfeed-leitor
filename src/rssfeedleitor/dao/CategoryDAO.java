package rssfeedleitor.dao;

import java.util.List;

import rssfeedleitor.model.Category;

public interface CategoryDAO {

		public void insert(Category category);

		public List<Category> findAll();

		public Category findById(Integer id);

		public Category findByTitle(String title);
}
