

compile() {
  current_dir_folder=${PWD##*/}
  out_dir="./out/production/$current_dir_folder"
  mkdir -p $out_dir
  javac -d $out_dir ./src/*
}

solve() {
  current_dir_folder=${PWD##*/}
  out_dir="./out/production/$current_dir_folder"
  java -cp $out_dir Problem < $1 > $2
}

solve_all() {
  input_dir="./problem/in"
  output_dir="./problem/out"
  mkdir -p $input_dir
  mkdir -p $output_dir
  for file in $(ls $input_dir); do
    in_extension=.in
    out_extension=.out
    file_name=${file%$in_extension}
    solve $input_dir/$file "$output_dir/$file_name$out_extension"
  done
}

compile
solve_all
