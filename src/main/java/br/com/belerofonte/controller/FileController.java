package br.com.belerofonte.controller;

import br.com.belerofonte.dao.ApplicationFileDAO;
import br.com.belerofonte.model.ApplicationFile;
import br.com.belerofonte.service.FileService;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Resource
public class FileController {

	private ApplicationFileDAO applicationFileDAO;
	private FileService applicationFileService;

	public FileController(ApplicationFileDAO applicationFileDAO, FileService applicationFileService) {
		this.applicationFileDAO = applicationFileDAO;
		this.applicationFileService  = applicationFileService;
	}

	public void create(UploadedFile uploadedFile, ApplicationFile applicationFile) {
		this.applicationFileService.create(uploadedFile,applicationFile);
	}

	public void delete(long id) {
		this.applicationFileDAO.delete(this.applicationFileDAO.load(id));
	}

	public void update(ApplicationFile applicationFile) {
		this.applicationFileDAO.update(applicationFile);
	}
}