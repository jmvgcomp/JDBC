package DAOProject.model.dao;

import DAOProject.model.entities.Department;

import java.util.List;

public interface DAO<T> {

    void insert(T t);
    void update(T t);
    void deleteById(Integer id);
    T findById(Integer id);
    List<T> findAll();
    List<T> findByDepartment(Department department);
}
