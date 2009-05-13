package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class OrderingListDemoBean {
	
	private List<OptionItem> items = new ArrayList<OptionItem>();
	private Set<OptionItem> selections = new HashSet<OptionItem>();
	private String controlsType = "link";
	private String controlsHorizontalAlign = "right";
	private String controlsVerticalAlign = "top";
	private String captionLabel = "Caption";
	
	private String ontopclick = "new Effect.Highlight('form:ontopclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	private String onbottomclick = "new Effect.Highlight('form:onbottomclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	
	private boolean orderControlsVisible = true;
	private boolean fastOrderControlsVisible = true;
	
	public OrderingListDemoBean() {
		for (int i = 0; i < 4; i++) {
			items.add(new OptionItem("Item " + i, new Random().nextInt(2000)));
		}
	}
	
	public void setItems(List<OptionItem> items) {
		this.items = items;
	}
	
	public List getItems() {
		return items;
	}

	public String getControlsType() {
		return controlsType;
	}

	public void setControlsType(String controlsType) {
		this.controlsType = controlsType;
	}

	public String getControlsHorizontalAlign() {
		return controlsHorizontalAlign;
	}

	public void setControlsHorizontalAlign(String controlsHorizontalAlign) {
		this.controlsHorizontalAlign = controlsHorizontalAlign;
	}

	public String getControlsVerticalAlign() {
		return controlsVerticalAlign;
	}

	public void setControlsVerticalAlign(String controlsVerticalAlign) {
		this.controlsVerticalAlign = controlsVerticalAlign;
	}

	public String getCaptionLabel() {
		return captionLabel;
	}

	public void setCaptionLabel(String captionLabel) {
		this.captionLabel = captionLabel;
	}

	public boolean isOrderControlsVisible() {
		return orderControlsVisible;
	}

	public void setOrderControlsVisible(boolean orderControlsVisible) {
		this.orderControlsVisible = orderControlsVisible;
	}

	public boolean isFastOrderControlsVisible() {
		return fastOrderControlsVisible;
	}

	public void setFastOrderControlsVisible(boolean fastOrderControlsVisible) {
		this.fastOrderControlsVisible = fastOrderControlsVisible;
	}

	public Object getActionResult() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("actionResult");
	}

	public String getOntopclick() {
		return ontopclick;
	}

	public void setOntopclick(String ontopclick) {
		this.ontopclick = ontopclick;
	}

	public String getOnbottomclick() {
		return onbottomclick;
	}

	public void setOnbottomclick(String onbottomclick) {
		this.onbottomclick = onbottomclick;
	}

	public Set<OptionItem> getSelections() {
		return selections;
	}

	public void setSelections(Set<OptionItem> selections) {
		this.selections = selections;
	}

	

	public void addItem() {
		this.items.add(new OptionItem("Item " + this.items.size(), new Random().nextInt(2000)));
	}

	public void clear() {
		this.items.clear();
	}
	
	public String testAction() {
		for (Object aa : items) {
			OptionItem aaa = (OptionItem)aa;
			System.out.println(aaa.getName());
			System.out.println(aaa.isSelected());
		}
		return null;
	}
	
	public void testActionListener(ValueChangeEvent event) {
		for (Object cc : selections) {
			OptionItem aa = (OptionItem)cc;
			aa.setSelected(Boolean.TRUE);
			for (Object dd : items) {
				OptionItem bb = (OptionItem)dd;
				if (aa.getName().equals(bb.getName())) {
					bb.setSelected(Boolean.TRUE);
				}
			}
		}
		
	}
}
