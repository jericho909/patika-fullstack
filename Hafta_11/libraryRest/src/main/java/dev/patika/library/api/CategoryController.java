package dev.patika.library.api;

import dev.patika.library.business.abstracts.ICategoryService;
import dev.patika.library.core.config.modelmapper.IModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultWithData;
import dev.patika.library.core.utils.ResultHelper;
import dev.patika.library.dto.requests.category.CategorySaveRequest;
import dev.patika.library.dto.requests.category.CategoryUpdateRequest;
import dev.patika.library.dto.responses.category.CategoryResponse;
import dev.patika.library.dto.responses.CursorResponse;
import dev.patika.library.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories/")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category categoryToBeSaved = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(categoryToBeSaved);
        return ResultHelper.created(this.modelMapper.forResponse().map(categoryToBeSaved, CategoryResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<CategoryResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Category> categoryPage = this.categoryService.cursor(page, pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage.map(
                category -> this.modelMapper.forResponse().map(category, CategoryResponse.class));
        return ResultHelper.cursor(categoryResponsePage);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> get(@PathVariable("id") int id){
        Category category = this.categoryService.get(id);
        return ResultHelper.ok(this.modelMapper.forResponse().map(category, CategoryResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        Category updatedCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updatedCategory);
        return ResultHelper.ok(this.modelMapper.forResponse().map(updatedCategory, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")int id){
        this.categoryService.delete(id);
        return ResultHelper.successfulOperation();
    }
}
