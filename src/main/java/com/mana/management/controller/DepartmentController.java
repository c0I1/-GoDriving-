package com.mana.management.controller;
import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.Department;
import com.mana.management.service.DepartmentService;
import com.mana.management.vo.DepartmentSelectVo;
import com.mana.management.vo.ResultVo;
import com.mana.management.vo.input.DepartmentForm;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
public class DepartmentController {
    
    @Resource
    DepartmentService departmentService;
    
    @GetMapping("/department/list")
    public PageInfo<Department> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return departmentService.findAll(page, size);
    }
    
    @GetMapping("/department/all")
    public List<Department> all() {
        return departmentService.all();
    }
    
    @PostMapping("/department/search")
    public PageInfo<Department> search(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "departmentName") String departmentName) {
        return departmentService.search(departmentName, page, size);
    }
    
    @GetMapping("/department/select")
    public List<DepartmentSelectVo> selectList() {
        return departmentService.findSelect();
    }
    
    @GetMapping("/department/{id}")
    public Department findById(@PathVariable Integer id) {
        return departmentService.find(id);
    }
    
    @PostMapping("/department")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid DepartmentForm department) {
        departmentService.insert(department);
        return ResultVo.success();
    }
    
    @PutMapping("/department/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody DepartmentForm department, @PathVariable Integer id) {
        departmentService.updateById(id, department);
        return ResultVo.success();
    }
    
    @DeleteMapping("/department/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return ResultVo.success();
    }
    
    @DeleteMapping("/department")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        departmentService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
