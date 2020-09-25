package br.com.fiap.EpicTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.EpicTask.model.Task;
import br.com.fiap.EpicTask.repository.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@GetMapping()
	public ModelAndView tasks() {
		List<Task> tasks = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("tasks");
		modelAndView.addObject("tasks", tasks);
		return modelAndView;
	}
	
	@PostMapping ()
	public String save(Task task) {
		repository.save(task);
		return "redirect:task";
	}
	
	//Vai me retorna formulário para cadastrar uma nova task
	@RequestMapping("/new")
	public String formTasks(Task taks) {
		//Vai retornar um view que defini como tarefa_new
		return "tarefa_new";
		}
	
	//Retorna tarefa_edit
	@RequestMapping("tf_edit")
	public String formTasksEdit() {
		//Vai retornar uma tarefa para editar
		return "tarefa_edit";
	}
}
	
