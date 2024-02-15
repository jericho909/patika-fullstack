package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultWithData;
import dev.patika.ecommerce.core.utils.ResultHelper;
import dev.patika.ecommerce.dto.requests.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.requests.category.CategoryUpdateRequest;
import dev.patika.ecommerce.dto.requests.supplier.SupplierSaveRequest;
import dev.patika.ecommerce.dto.requests.supplier.SupplierUpdateRequest;
import dev.patika.ecommerce.dto.responses.CursorResponse;
import dev.patika.ecommerce.dto.responses.category.CategoryResponse;
import dev.patika.ecommerce.dto.responses.supplier.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapperService;

    public SupplierController(ISupplierService supplierService, IModelMapperService modelMapperService) {
        this.supplierService = supplierService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<SupplierResponse> save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest){
        Supplier saveSupplier = this.modelMapperService.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(saveSupplier);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveSupplier, SupplierResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<SupplierResponse> get(@PathVariable("id") int id){
        Supplier supplier = this.supplierService.get(id);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(supplier, SupplierResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<SupplierResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Supplier> supplierPage = this.supplierService.cursor(page, pageSize);
        Page<SupplierResponse> supplierResponsePage = supplierPage.map(
                supplier -> this.modelMapperService.forResponse().map(supplier, SupplierResponse.class));


        return ResultHelper.cursor(supplierResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<SupplierResponse> update(@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest){
        Supplier updatedSupplier = this.modelMapperService.forRequest().map(supplierUpdateRequest, Supplier.class);
        if (updatedSupplier.getAddress() == null){
            updatedSupplier.setAddress(this.supplierService.get(supplierUpdateRequest.getId()).getAddress());
        }
        if (updatedSupplier.getContactName() == null){
            updatedSupplier.setContactName(this.supplierService.get(supplierUpdateRequest.getId()).getContactName());
        }
        if (updatedSupplier.getMail() == null){
            updatedSupplier.setMail(this.supplierService.get(supplierUpdateRequest.getId()).getMail());
        }
        this.supplierService.update(updatedSupplier);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(updatedSupplier, SupplierResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.supplierService.delete(id);
        return ResultHelper.successfulOperation();
    }

}
