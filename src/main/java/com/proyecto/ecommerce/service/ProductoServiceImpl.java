package com.proyecto.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.model.Producto;
import com.proyecto.ecommerce.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto save(Producto producto) {
		
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		
		//Cuando al objeto le mandamos un null este lo crea, pero si existe en la base de datos lo actualiza
		//Por eso se utiliza en el update
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);
		
	}

}
