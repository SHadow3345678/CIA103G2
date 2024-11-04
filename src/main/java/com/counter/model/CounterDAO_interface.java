package com.counter.model;

import java.util.*;

public interface CounterDAO_interface {
	 public void insert(CounterVO counterVO);
     public void update(CounterVO counterVO);
     public void delete(Integer counterNo);
     public CounterVO findByPrimaryKey(Integer counterNo);
     public List<CounterVO> getAll();



}
