package com.example.responsi;

//public class FragmentRujuk extends Fragment {
//    AdapterRujuk adapter;
//    VirusDataService virusDataService;
//    String[][] dataList;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        virusDataService = new VirusDataService(getActivity());
//        callAPI();
//        return inflater.inflate(R.layout.fragment_rujuk, container, false);
//    }
//
//    public void callAPI() {
//        virusDataService.getRujuk(new VirusDataService.VolleyResponseListener() {
//
//            @Override
//            public void onError(String message) {
//                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(List<DataKasus> konten) {
//                dataList = konten;
//                adapter = new AdapterRujuk(getActivity(),dataList);
//            }
//
//        });
//    }
//}