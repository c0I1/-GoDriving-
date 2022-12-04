package com.mana.management.controller;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalTrain;
import com.mana.management.service.PersonalTrainService;
import com.mana.management.vo.ResultVo;
import com.mana.management.vo.input.PersonalTrainForm;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 奖惩管理
 */
@RestController
public class PersonalTrainController {

    @Resource
    PersonalTrainService personalTrainService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param departmentName
     * @param personalId
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping("/train/list")
    public PageInfo<PersonalTrain> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size,
                                        @RequestParam(value = "departmentName", required = false) String departmentName,
                                        @RequestParam(value = "personalId", defaultValue = "0") Integer personalId,
                                        @RequestParam(value = "beginDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                                        @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return personalTrainService.findAll(page, size, departmentName, personalId, beginDate, endDate);
    }

    /**
     * 整体查询
     * @return
     */
    @GetMapping("/train/all")
    public List<PersonalTrain> all() {
        return personalTrainService.all();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/train/{id}")
    public PersonalTrain findById(@PathVariable Integer id) {
        return personalTrainService.find(id);
    }

    /**
     * 增加
     * @param personalTrainForm
     * @return
     */
    @PostMapping("/train")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid PersonalTrainForm personalTrainForm) {
        personalTrainService.insert(personalTrainForm);
        return ResultVo.success();
    }

    /**
     * 更新
     * @param personalTrainForm
     * @param id
     * @return
     */
    @PutMapping("/train/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody @Valid PersonalTrainForm personalTrainForm, @PathVariable Integer id) {
        personalTrainService.updateById(id, personalTrainForm);
        return ResultVo.success();
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @DeleteMapping("/train/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        personalTrainService.deleteById(id);
        return ResultVo.success();
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @DeleteMapping("/train")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        personalTrainService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
