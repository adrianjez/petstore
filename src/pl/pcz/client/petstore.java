package pl.pcz.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.core.client.*;
import com.google.gwt.core.client.Scheduler.*;
import java.awt.event.*;

public class petstore implements EntryPoint {

    private FlexTable table = new FlexTable();
    private Label id = new Label("123");
    private Label name = new Label("Spot");
    private Label category = new Label("reserved");
    
    private HorizontalPanel mMiddle = new HorizontalPanel();
    
    //** Details fields
    private VerticalPanel mDetailsPanel = new VerticalPanel();

	//** Counter fields
	private Label mCounterContainer = new Label("Counter");
	
    public void onModuleLoad() {
		// Sample pet data.
		table.setText(0, 0, "123");
		table.setText(0, 1, "Spot");

		VerticalPanel right = new VerticalPanel();
		
		FlowPanel f1 = new FlowPanel();
		f1.add(new Label("ID:"));
		f1.add(id);
		FlowPanel f2 = new FlowPanel();
		f1.add(new Label("Name:"));
		f1.add(name);
		FlowPanel f3 = new FlowPanel();
		f1.add(new Label("Category:"));
		f1.add(category);
		/*
		f1.addClickHandler(new ClickHanddler() {
			
			public onClick(ClickEvent event){
				Cell cell = ((HTMLTable)event.getSource()).getCellForEvent(event);
				System.out.println("GridClickHandler: ("+cell.getRowIndex()+","+cell.getCellIndex()+")");
			}
		});*/
		right.add(f1);
		right.add(f2);
		right.add(f3);
		
		mMiddle.add(table);
		mMiddle.add(right);
		mMiddle.add(mDetailsPanel);
		
		mMiddle.setStyleName("table");
		Label header = new Label("Petstore");
		header.setStyleName("top-header");

		FlowPanel footer = new FlowPanel();
		footer.add(new Label("Kontakt: "));
		footer.add(new Anchor("office@petstore.pcz.pl",
					  "mailto: office@petstore.pcz.pl"));
		footer.setStyleName("footer");

		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("max-width");
		vp.add(mCounterContainer);
		vp.add(header);
		vp.add(mMiddle);
		vp.add(footer);
		RootPanel.get().add(vp);
		
		Scheduler.get().scheduleFixedPeriod(new RepeatingCommand(){
			int a = 0;
			public boolean execute(){
				a++;
				mCounterContainer.setText("Count: " + a);
				return true;
			}	
		}, 1000);
    }
    
    //** Private methods 
    private void loadDetails(String id, String name, String category){			
		FlowPanel f1Details = new FlowPanel();
		f1Details.add(new Label("ID:"));
		f1Details.add(new Label(id));
		f1Details.add(new Label("Name:"));
		f1Details.add(new Label(name));
		f1Details.add(new Label("Category:"));
		f1Details.add(new Label(category));
		
		mDetailsPanel.clear();
		mDetailsPanel.add(f1Details);
	}
		
}
