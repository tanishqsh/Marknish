package com.tanishqsharma.marknish;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tanishq Sharma (tanishq.xyz)
 * NishParse allows you to parse all the elements and return the
 * formatted text accordingly placed in the view.
 *
 * We will be using a LinearLayout to return the favor.
 * The returned LinearLayout will be used to add where ever the
 * developer requires it.
 *
 * The mainView(LinearLayout) is a match_parent layout in both width and height.
 * If you want to use it under some constraints, try putting it in a container in
 * the calling class.
 */

public class NishParser {

    /**
     @params
     mContext (Context) to use it with view layouts
     mUnformattedString (String) to store the unformatted string
     mainView (Linearlayout) to store the complete view that has to be returned.
     */

    private Context mContext;
    private LinearLayout mainView;

    /**
     * Elementary Lists to store the extracted values of each kind.
     */

    private  List<String> headings;
    private List<String> images;
    private List<String> bold;
    private List<String> bullet;
    private List<String> paragraph;


    private boolean contentCollection = false;


    /* END
     * Temporary Elements to be deleted in the production version
     */

    public NishParser(Context context) {
        mContext = context;
        mainView = new LinearLayout(context);
        initializeLists();
        initializeMainView();

    }

    private void initializeLists(){
        headings = new ArrayList<>();
        images = new ArrayList<>();
        bold =  new ArrayList<>();
        bullet =  new ArrayList<>();
        paragraph =  new ArrayList<>();
    }

    private void initializeMainView(){
        mainView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mainView.setOrientation(LinearLayout.VERTICAL);
    }

    public LinearLayout ReturnView(String unformattedString){

        Parser(unformattedString);
        return mainView;
    }

    private void Parser(String tobeParsed){

        /*
        The parser needs to go through the tobeParsed string completely atleast once.
         */

        String temp_tag = "";
        boolean startTagCollection = false;

        for(int i=0; i<tobeParsed.length(); i++){
            char ch = tobeParsed.charAt(i);

            // starts the tag collection
            if(ch=='<'){
                startTagCollection = true;
            }

            if(startTagCollection){
                temp_tag = temp_tag.concat(String.valueOf(ch));
            } else{
                //nothing for now
            }

            if(ch=='>'){
                if(tobeParsed.charAt(i-1)=='/'){
                    //escape sequence if > or < is used somewhere in the general text.
                    //do nothing
                } else {
                    startTagCollection = false;
                    contentCollection = true;
                    i = ElementDecider(temp_tag, i+1, tobeParsed);
                    temp_tag = "";
                }

            }
        }
    }

    private int ElementDecider(String tempTag, int posInString, String tobeParsed){

        int currentI = posInString;

        switch (tempTag){
            case "<n_heading>":
                /* It is a heading tag. Since the content collection is on, we store everything
                in a temporary string and then just add this in the headings list.
                 */
                String head_temp = "";
                boolean keepIterating_Head = true;
                do{

                    char ch = tobeParsed.charAt(currentI);
                    currentI++;
                    if(ch=='<'){
                        /*do nothing // set the content collection false
                        to stop the content collection of the text.
                        till you get the closing bracket of this
                        and then pass the control back to method parser with the changed i position.
                         */
                        contentCollection = false;
                        headings.add(head_temp);

                        //we can stop iterating once we know the closing bracket has started
                        keepIterating_Head = false;

                        //find the next closing tag of the closing bracket and set the i positing, everything else is insignificant
                        currentI = tobeParsed.indexOf('>', currentI);

                        /*
                        Create a heading_textview and add it to the mainView
                         */
                        mainView.addView(new n_heading(mContext, head_temp));
                        mainView.addView(new separator(mContext));

                        head_temp = ""; //reinitialized

                    } else if(contentCollection) {
                        /*
                        If it is not the closing tag, we continue to collect the content between the tags
                         */
                        head_temp = head_temp.concat(String.valueOf(ch));
                    }

                } while (keepIterating_Head);
                break;

            case "<n_paragraph>":
                /* It is a paragraph tag. Since the content collection is on, we store everything
                in a temporary string and then just add this in the paragraph's list.
                 */

                String para_temp = "";
                boolean keepIterating_Para = true;

                do{

                    char ch = tobeParsed.charAt(currentI);
                    currentI++;
                    if(ch=='<'){
                        /*do nothing // set the content collection false
                        to stop the content collection of the text.
                        till you get the closing bracket of this
                        and then pass the control back to method parser with the changed i position.
                         */
                        contentCollection = false;
                        paragraph.add(para_temp);

                        //we can stop iterating once we know the closing bracket has started
                        keepIterating_Para = false;

                        //find the next closing tag of the closing bracket and set the i positing, everything else is insignificant
                        currentI = tobeParsed.indexOf('>', currentI);

                        /*
                        Create a paragraph_textview and add it to the mainView
                         */
                        mainView.addView(new n_paragraph(mContext, para_temp));

                        para_temp = ""; //reinitialized

                    } else if(contentCollection) {
                        /*
                        If it is not the closing tag, we continue to collect the content between the tags
                         */
                        para_temp = para_temp.concat(String.valueOf(ch));
                    }

                } while (keepIterating_Para);

                break;

            case "<n_bullet>":
                /* It is a bullet tag. Since the content collection is on, we store everything
                in a temporary string and then just add this in the bullet's list.
                 */

                String bullet_temp = "";
                boolean keepIterating_bullet = true;

                do{
                    char ch = tobeParsed.charAt(currentI);
                    currentI++;
                    if(ch=='<'){
                        /*do nothing // set the content collection false
                        to stop the content collection of the text.
                        till you get the closing bracket of this
                        and then pass the control back to method parser with the changed i position.
                         */
                        contentCollection = false;
                        bullet.add(bullet_temp);

                        //we can stop iterating once we know the closing bracket has started
                        keepIterating_bullet = false;

                        //find the next closing tag of the closing bracket and set the i positing, everything else is insignificant
                        currentI = tobeParsed.indexOf('>', currentI);

                        /*
                        Create a paragraph_textview and add it to the mainView
                         */
                        mainView.addView(new n_bullet(mContext, bullet_temp));

                        bullet_temp = ""; //reinitialized

                    } else if(contentCollection) {
                        /*
                        If it is not the closing tag, we continue to collect the content between the tags
                         */
                        bullet_temp = bullet_temp.concat(String.valueOf(ch));
                    }

                } while (keepIterating_bullet);

                break;

            case "<n_image>":
                /* It is am image tag. Since the content collection is on, we store everything
                in a temporary string and then just add this in the bullet's list.
                 */

                String image_url_temp = "";
                boolean keepIterating_image = true;

                do{
                    char ch = tobeParsed.charAt(currentI);
                    currentI++;
                    if(ch=='<'){
                        /*do nothing // set the content collection false
                        to stop the content collection of the text.
                        till you get the closing bracket of this
                        and then pass the control back to method parser with the changed i position.
                         */
                        contentCollection = false;
                        images.add(image_url_temp);

                        //we can stop iterating once we know the closing bracket has started
                        keepIterating_image = false;

                        //find the next closing tag of the closing bracket and set the i positing, everything else is insignificant
                        currentI = tobeParsed.indexOf('>', currentI);

                        /*
                        Create a imageview and add it to the mainView
                         */
                        mainView.addView(new n_image(mContext, image_url_temp));

                        bullet_temp = ""; //reinitialized

                    } else if(contentCollection) {
                        /*
                        If it is not the closing tag, we continue to collect the content between the tags
                         */
                        image_url_temp = image_url_temp.concat(String.valueOf(ch));
                    }

                } while (keepIterating_image);

                break;
        }

        return currentI;
    }

}

