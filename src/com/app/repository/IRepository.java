package com.app.repository;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepository {
	// read files
	default ArrayList<?> read() throws IOException {
		return null;
	}
}
