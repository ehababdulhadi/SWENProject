package userInterface;

    import java.awt.BorderLayout;  
    import java.awt.BorderLayout;  
    import java.awt.Container;  
    import java.util.HashMap;  
    import javax.swing.SwingUtilities;  
      
    /** 
     * Used to switch views within a container. 
     * 
     * @author FHMP 
     */  
    public class ViewSwitcher {  
      
        /** 
         * Map to keep track of views according to their specified names 
         */  
        private HashMap<String, Container> views = new HashMap<String, Container>();  
        /** 
         * The host container that contains the views to be switched between 
         */  
        private Container host;  
        /** 
         * Used to keep track of the current view 
         */  
        private Container current;  
      
        public ViewSwitcher() {}  
      
        public ViewSwitcher(Container host) {  
            this.host = host;  
        }  
      
        /** 
         * Registers a view bound to a specified name 
         * 
         * @param key 
         * @param view the view 
         */  
        public void registerView(Container view, Object key) {  
            views.put(key.toString(), view);  
        }  
      
        /** 
         * Sets the host container that will contain the view 
         * 
         * @param host the host container 
         */  
        public void setHost(Container host) {  
            this.host = host;  
        }  
      
        /**       
         * Switches to the view bound to the specified name 
         * 
         * @param key the key of the view to switch to 
         */  
        public void switchTo(final Object key) {  
            if(host == null) return;  
            SwingUtilities.invokeLater(new Runnable() {  
      
                public void run() {  
                    Container view = views.get(key.toString());  
      
                    if (current != null) {  
                        host.remove(current);  
                    }  
                    current = view;  
      
                    host.add(view, BorderLayout.CENTER);
                    host.validate();  
                    host.repaint(); // just to make sure    
                    
                    view.requestFocusInWindow();
                }  
            });  
      
        }  
    }  