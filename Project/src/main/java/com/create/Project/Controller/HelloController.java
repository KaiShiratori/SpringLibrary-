package com.create.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.create.Project.Entity.Library;
import com.create.Project.Model.LibraryRepository;
import com.create.Project.Service.LibraryService;

/** コントローラーの役目を果たしてくれるクラス
 * Controllerアノテーションを付ける
 */
@RestController
@RequestMapping("/api")
public class HelloController {

	//リポジトリを格納する用
	private LibraryRepository rep;

	//saveメソッドを呼んでデータを保存
	private LibraryService libService;

	//コンストラクタにリポジトリを注入
	@Autowired
	public void HelloController(LibraryRepository rep, LibraryService lib) {
		this.libService = lib;
		this.rep = rep;
	}

	@GetMapping("/")
	public String Start() {
		return "start";
	}
	//一覧画面を開く
	@GetMapping("/list")
	@ResponseBody
	public List<Library> list() {
		List<Library>  Libraryes = rep.findAll();
		return Libraryes;
	}
	//登録メソッド
	@PostMapping("/create")
	public void Create(@RequestBody Library request) {
		libService.save(request);
	}

	//更新画面に選択されたデータを返す
	@GetMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity<Library> update(@PathVariable Long id) {
		return new ResponseEntity<Library> (libService.findbyid(id),HttpStatus.OK);
	}

	//更新処理
	//戻り値と引数を変更
	@PostMapping("/update")
	public List<Library> update(@RequestBody Library request) {
		libService.save(request);
		return rep.findAll();
	}

	//削除処理
	//戻り値と引数を変更
	@DeleteMapping("/delete")
	public List<Library> delete(@RequestBody Library request) {
		libService.delete(request);
		return rep.findAll();
	}

	@PostMapping("/delete/{id}")
	public List<Library> delete(@PathVariable Long id) {
		libService.delete(id);
		return rep.findAll();
	}



}
