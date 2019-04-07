package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String addComment(@PathVariable(name = "imageId") Integer imageId, @PathVariable(name = "title") String title,Comment newComment, Model model) {
        Image image = imageService.getImageObject(imageId, title);
        commentService.addComment(newComment);
        model.addAttribute("image", image);
        model.addAttribute("comment", newComment);
        return "redirect:/images";
    }
}
