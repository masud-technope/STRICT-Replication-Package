public void actionPerformed(ActionEvent evt) {
    final HelpIndex index = getHelpIndex();
    if (index == null)
        return;
    results.setListData(new Result[] { new Result(jEdit.getProperty("helpviewer.searching")) });
    final String text = searchField.getText();
    final java.util.List<Result> resultModel = new ArrayList<Result>();
    ThreadUtilities.runInBackground(new Runnable() {

        public void run() {
            StringTokenizer st = new StringTokenizer(text, ",.;:-? ");
            // we later use this to compute a relative ranking
            int maxRank = 0;
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
                HelpIndex.Word lookup = index.lookupWord(word);
                if (lookup == null)
                    continue;
                for (int i = 0; i < lookup.occurCount; i++) {
                    HelpIndex.Word.Occurrence occur = lookup.occurrences[i];
                    boolean ok = false;
                    HelpIndex.HelpFile file = index.getFile(occur.file);
                    for (int j = 0; j < resultModel.size(); j++) {
                        Result result = resultModel.get(j);
                        if (result.file.equals(file.file)) {
                            result.rank += occur.count;
                            // multiple files w/ word bonus
                            result.rank += 20;
                            maxRank = Math.max(result.rank, maxRank);
                            ok = true;
                            break;
                        }
                    }
                    if (!ok) {
                        maxRank = Math.max(occur.count, maxRank);
                        resultModel.add(new Result(file, occur.count));
                    }
                }
            }
            if (maxRank != 0) {
                // turn the rankings into relative rankings, from 1 to 4
                for (int i = 0; i < resultModel.size(); i++) {
                    Result result = resultModel.get(i);
                    result.rank = (int) Math.ceil((double) result.rank * 4 / maxRank);
                }
                Collections.sort(resultModel, new ResultCompare());
            }
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    if (resultModel.isEmpty()) {
                        results.setListData(new Result[] { new Result(jEdit.getProperty("helpviewer.no-results")) });
                        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                    } else
                        results.setListData(resultModel.toArray(new Result[resultModel.size()]));
                }
            });
        }
    });
}