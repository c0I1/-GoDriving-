package com.mana.management.controller;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalSalary;
import com.mana.management.vo.input.PersonalSalaryForm;
import com.mana.management.service.PersonalSalaryService;
import com.mana.management.vo.ResultVo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * 薪资管理
 */
@RestController
public class PersonalSalaryController {
    @Resource
    PersonalSalaryService personalSalaryService;
    @GetMapping("/salary/list")
    public PageInfo<PersonalSalary> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "departmentName", required = false) String departmentName,
                                         @RequestParam(value = "year", defaultValue = "0") Integer year,
                                         @RequestParam(value = "month", defaultValue = "0") Integer month,
                                         @RequestParam(value = "personalId", defaultValue = "0") Integer personalId) {
        return personalSalaryService.findAll(year, month, departmentName, personalId, page, size);
    }
    @GetMapping("/salary/all")
    public List<PersonalSalary> all() {
        return personalSalaryService.all();
    }

    @GetMapping("/salary/{id}")
    public PersonalSalary findById(@PathVariable Integer id) {
        return personalSalaryService.find2(id);
    }

    @PostMapping("/salary")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid PersonalSalaryForm personalSalaryForm) {
        personalSalaryService.insert(personalSalaryForm);
        return ResultVo.success();
    }

    @PutMapping("/salary/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody @Valid PersonalSalaryForm personalSalaryForm, @PathVariable Integer id) {
        personalSalaryService.updateById(id, personalSalaryForm);
        return ResultVo.success();
    }

    @DeleteMapping("/salary/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        personalSalaryService.deleteById(id);
        return ResultVo.success();
    }

    @DeleteMapping("/salary")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        personalSalaryService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
