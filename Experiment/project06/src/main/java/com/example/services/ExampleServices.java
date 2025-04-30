package com.example.services;

public package com.example.services;
import com.example.dao.ExampleDao;
import com.example.entities.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ExampleService {
    @Autowired
    private ExampleDao exampleDao;
    @Transactional
    public void saveExample(ExampleEntity entity) {
        exampleDao.save(entity);
    }
} ExampleServices {
    
}
