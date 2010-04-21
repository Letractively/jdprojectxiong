package com.ejd.web.vo.genl;

import java.util.*;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.ExtendedTableDataModel;
import java.util.ArrayList;
import java.util.List;

public class AbstractExtendedTableDataModel<T> {
	private String sortMode="single";
	private String selectionMode="single";
	private int scrollerPage;
	private int recordNumberShow = 10;
	private UIExtendedDataTable table;
	private ExtendedTableDataModel<T> dataModel;

}
