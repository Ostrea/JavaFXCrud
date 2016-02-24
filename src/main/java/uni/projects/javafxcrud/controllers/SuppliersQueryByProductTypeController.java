package uni.projects.javafxcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.projects.javafxcrud.utils.DialogCreator;

@Component
public class SuppliersQueryByProductTypeController extends BaseController {

    @Autowired
    public SuppliersQueryByProductTypeController(DialogCreator dialogCreator) {
        super(dialogCreator);
    }
}
