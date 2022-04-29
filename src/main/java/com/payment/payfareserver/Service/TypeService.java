package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Type;
import com.payment.payfareserver.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public Type save(Type type) {
        return repository.save(type);
    }

    public List<Type> getAllTypes() {
        List<Type> types = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(types::add);
        return types;
    }

    public List<Type> getTypesByTypeName(String typeName) {
        return repository.findTypesByName(typeName);
    }

    public Type getTypeById(int typeId) {
        return repository.findTypeById(typeId);
    }

    public Type getTypeByName(String typeName) {
        return repository.findTypeByName(typeName);
    }

    public int getCount() {
        return (int) repository.count();
    }

}