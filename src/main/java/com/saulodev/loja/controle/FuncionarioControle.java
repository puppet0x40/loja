package com.saulodev.loja.controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saulodev.loja.modelos.Funcionario;
import com.saulodev.loja.repositorios.FuncionarioReposistorio;

@Controller
public class FuncionarioControle {

	@Autowired
	private FuncionarioReposistorio funcionarioReposistorio;
	
	@GetMapping("/administrativo/funcionario/cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionario/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@GetMapping("/administrativo/funcionario/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/funcionario/lista");
		mv.addObject("listaFuncionarios", funcionarioReposistorio.findAll());
		return mv;
	}
	
	@PostMapping("/administrativo/funcionario/salvar")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(funcionario);
		}
		
		funcionarioReposistorio.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
	}
	
}
