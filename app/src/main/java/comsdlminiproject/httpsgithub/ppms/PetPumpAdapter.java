package comsdlminiproject.httpsgithub.ppms;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PetPumpAdapter extends ArrayAdapter<PetPumpDB>
{
    private Activity context;
    private List<PetPumpDB> petPumpList;


    public PetPumpAdapter(Activity context, List<PetPumpDB> petPumpList)
    {
        super(context, R.layout.activity_list_view, petPumpList);
        this.context=context;
        this.petPumpList = petPumpList;
    }



    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_list_view,null, true);

        TextView editDate = listViewItem.findViewById(R.id.editDate);
        TextView editPetPrice = listViewItem.findViewById(R.id.editPetPrice);
        TextView editDiePrice = listViewItem.findViewById(R.id.editDiePrice);
        TextView editPetSold = listViewItem.findViewById(R.id.editPetSold);
        TextView editDieSold = listViewItem.findViewById(R.id.editDieSold);
        TextView editPetEarn = listViewItem.findViewById(R.id.editPetEarn);
        TextView editDieEarn = listViewItem.findViewById(R.id.editDieEarn);
        TextView editTotEarn = listViewItem.findViewById(R.id.editTotEarn);


        PetPumpDB petpumpobj = petPumpList.get(position);

        editDate.setText(petpumpobj.getDate());
        editPetPrice.setText(petpumpobj.getPetrolPrice());
        editDiePrice.setText(petpumpobj.getDieselPrice());
        editPetSold.setText(petpumpobj.getPetrolSold());
        editDieSold.setText(petpumpobj.getDieselSold());
        editPetEarn.setText(petpumpobj.getPetrolEarn());
        editDieEarn.setText(petpumpobj.getDieselEarn());
        editTotEarn.setText(petpumpobj.getTotalEarn());

        return listViewItem;
    }

}
