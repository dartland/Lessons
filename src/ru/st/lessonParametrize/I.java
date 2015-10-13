package ru.st.lessonParametrize;

import java.util.List;

public interface I<T extends Base> {
	public List<T> getAll();
}
