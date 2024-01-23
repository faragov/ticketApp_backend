package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;

import java.util.List;

public interface ProductService {
  Product convertDtoToProduct(NewProductDTO newProductDTO);

  void deleteProduct(Long id);

  void editProduct(Long id, EditProductDTO editProductDTO);

  void saveNewProduct(Product newProduct);

  public List<Product> getAllProducts();

  public GetProductListDTO listAllProducts();
}
