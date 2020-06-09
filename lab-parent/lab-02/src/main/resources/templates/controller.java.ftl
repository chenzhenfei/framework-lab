package ${package.Controller};

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.core.metadata.IPage;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@Slf4j
@RequestMapping("<#if package.ModuleName??>value="/${package.ModuleName}"</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping(value="add")
    public int add(@RequestBody ${entity} ${entity?uncap_first}){
        return ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first});
    }

    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return ${(table.serviceName?substring(1))?uncap_first}.delete(id);
    }

    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping(value="update")
    public int update(@RequestBody ${entity} ${entity?uncap_first}){
        return ${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first});
    }

    @ApiOperation(value = "查询${table.comment!}分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping
    public IPage<${entity}> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return ${(table.serviceName?substring(1))?uncap_first}.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询${table.comment!}")
    @GetMapping("{id}")
    public ${entity} findById(@PathVariable Long id){
        return ${(table.serviceName?substring(1))?uncap_first}.findById(id);
    }

}
</#if>