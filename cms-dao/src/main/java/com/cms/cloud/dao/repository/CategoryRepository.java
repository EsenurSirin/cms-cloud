package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {

    @Query("select c from Category c where c.name =:categoryName")
    List<Category> getCategoryListByCategoryName(@Param("categoryName") String categoryName);
}
