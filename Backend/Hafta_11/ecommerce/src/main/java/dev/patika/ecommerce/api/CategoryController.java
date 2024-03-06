package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultWithData;
import dev.patika.ecommerce.core.utils.ResultHelper;
import dev.patika.ecommerce.dto.requests.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.requests.category.CategoryUpdateRequest;
import dev.patika.ecommerce.dto.responses.CursorResponse;
import dev.patika.ecommerce.dto.responses.category.CategoryResponse;
import dev.patika.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapperService;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapperService) {
        this.categoryService = categoryService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category saveCategory = this.modelMapperService.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveCategory, CategoryResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> get(@PathVariable("id") int id){
        Category category = this.categoryService.get(id);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(category, CategoryResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<CategoryResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Category> categoryPage = this.categoryService.cursor(page, pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage.map(
                category -> this.modelMapperService.forResponse().map(category, CategoryResponse.class));


        return ResultHelper.cursor(categoryResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        Category updatedCategory = this.modelMapperService.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updatedCategory);
        return ResultHelper.ok(this.modelMapperService.forResponse().map(updatedCategory, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.categoryService.delete(id);
        return ResultHelper.successfulOperation();
    }


}
