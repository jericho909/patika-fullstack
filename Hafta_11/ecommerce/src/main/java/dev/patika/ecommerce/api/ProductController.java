package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.business.abstracts.IProductService;
import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.ResultWithData;
import dev.patika.ecommerce.core.utils.ResultHelper;
import dev.patika.ecommerce.dto.requests.product.ProductSaveRequest;
import dev.patika.ecommerce.dto.responses.product.ProductResponse;
import dev.patika.ecommerce.dto.responses.supplier.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final IProductService productService;
    private final ICategoryService categoryService;
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapperService;

    public ProductController(IProductService productService,
                             ICategoryService categoryService,
                             ISupplierService supplierService,
                             IModelMapperService modelMapperService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest){
        Product saveProduct = this.modelMapperService.forRequest().map(productSaveRequest, Product.class);
        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        saveProduct.setCategory(category);
        saveProduct.setSupplier(supplier);
        this.productService.save(saveProduct);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveProduct, ProductResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<ProductResponse> get(@PathVariable("id") int id){
        Product product = this.productService.get(id);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(product, ProductResponse.class));
    }
    @GetMapping("/{id}/supplier")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<SupplierResponse> getSupplier(@PathVariable("id") int id){
        Supplier supplier = this.supplierService.get(id);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(supplier, SupplierResponse.class));
    }

}
