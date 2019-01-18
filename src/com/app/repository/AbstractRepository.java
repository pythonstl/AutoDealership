package com.app.repository;

abstract class AbstractRepository implements IRepository {
	protected String PATH = "C:\\Claim Academy Workspace\\Workspace2\\AsianImports\\WebContent\\data\\";

	protected String getFilePath() {
		return PATH;
	}
	protected void setPath(String path) {
		this.PATH = path;
	}
}
