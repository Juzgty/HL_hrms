package cn.hl.hlhrms.controller;

import cn.hl.hlhrms.entity.Position;
import cn.hl.hlhrms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 职位控制器类
 */
@Controller
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    /**
     * 获取所有职位信息
     *
     * @param model 存储职位列表
     * @return 职位列表页面
     */
    @GetMapping("/list")
    public String listAllPositions(Model model) {
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("positions", positions);
        System.out.println("职位列表：" + positions);
        return "position"; // 返回职位列表页面
    }

    /**
     * 添加职位页面
     *
     * @return 添加职位页面视图
     */
    @GetMapping("/add")
    public String addPositionPage() {
        return "addposition"; // Thymeleaf 视图模板
    }

    /**
     * 添加职位处理
     *
     * @param position 职位信息
     * @param model    存储反馈信息
     * @return 职位添加成功页面
     */
    @PostMapping("/add")
    public String addPosition(@ModelAttribute Position position, Model model) {
        Position savedPosition = positionService.addPosition(position);
        model.addAttribute("position", savedPosition);
        return "redirect:/position/list"; // 添加完成后返回职位列表页面
    }

    /**
     * 修改职位页面
     *
     * @param positionId 职位ID
     * @param model      存储职位信息
     * @return 修改职位页面视图
     */
    @GetMapping("/edit/{id}")
    public String editPositionPage(@PathVariable("id") Integer positionId, Model model) {
        Position position = positionService.findPositionById(positionId);
        model.addAttribute("position", position);
        return "position/edit"; // Thymeleaf 视图模板
    }

    /**
     * 修改职位处理
     *
     * @param position 职位信息
     * @param model    存储反馈信息
     * @return 修改后的职位列表页面
     */
    @PostMapping("/edit")
    public String editPosition(@ModelAttribute Position position, Model model) {
        Position updatedPosition = positionService.updatePosition(position);
        model.addAttribute("position", updatedPosition);
        return "redirect:/position/list"; // 更新后返回职位列表页面
    }
}
