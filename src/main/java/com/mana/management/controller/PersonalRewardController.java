package com.mana.management.controller;

import com.github.pagehelper.PageInfo;
import com.mana.management.pojo.PersonalReward;
import com.mana.management.service.PersonalRewardService;
import com.mana.management.vo.ResultVo;
import com.mana.management.vo.input.PersonalRewardForm;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class PersonalRewardController {

    @Resource
    PersonalRewardService personalRewardService;

    /**
     * 分页
     * @param page
     * @param size
     * @param departmentName
     * @param personalId
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/reward/list")
    public PageInfo<PersonalReward> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "departmentName", required = false) String departmentName,
                                         @RequestParam(value = "personalId", defaultValue = "0") Integer personalId,
                                         @RequestParam(value = "year", defaultValue = "0") Integer year,
                                         @RequestParam(value = "month", defaultValue = "0") Integer month) {
        return personalRewardService.findAll(year, month, departmentName, personalId, page, size);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/reward/all")
    public List<PersonalReward> all() {
        return personalRewardService.all();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/reward/{id}")
    public PersonalReward findById(@PathVariable Integer id) {
        return personalRewardService.find(id);
    }

    /**
     * 增加
     * @param personalRewardForm
     * @return
     */
    @PostMapping("/reward")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid PersonalRewardForm personalRewardForm) {
        personalRewardService.insert(personalRewardForm);
        return ResultVo.success();
    }

    /**
     * 根据id更新
     * @param personalRewardForm
     * @param id
     * @return
     */
    @PutMapping("/reward/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody @Valid PersonalRewardForm personalRewardForm, @PathVariable Integer id) {
        personalRewardService.updateById(id, personalRewardForm);
        return ResultVo.success();
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/reward/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        personalRewardService.deleteById(id);
        return ResultVo.success();
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @DeleteMapping("/reward")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        personalRewardService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
