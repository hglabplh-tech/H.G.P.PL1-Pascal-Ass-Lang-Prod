(defproject hgp.genbytec/H.G.P.PL1-Pascal-Ass-Lang "1.0.0-SNAPSHOT" ; version "1.0.0-SNAPSHOT
  :description "H.G.P.PL1-Pascal-Ass-Lang"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.11.1"]
   [org.ow2.asm/asm "9.6"]
   [org.ow2.asm/asm-commons "9.6"]
   [org.ow2.asm/asm-util "9.6"]
   [org.ow2.asm/asm-tree "9.6"]
   [org.ow2.asm/asm-analysis "9.6"]
   [org.clojure/core.async "1.6.681"]
   [de.active-group/active-clojure "0.42.2"]
   [clojure-interop/apache-commons-io "1.0.0"]
   [log4j/log4j "1.2.17"]
   [org.javassist/javassist "3.25.0-GA"]
   [org.antlr/antlr4 "4.13.1"]
   [org.antlr/antlr4-maven-plugin "4.3"]
   [commons-cli/commons-cli "1.6.0"]]
  :source-paths ["src"]
  :java-source-paths ["src/main/java"]                      ; Java source is stored separately.
  :test-paths ["test/clj"]
  :resource-paths ["resource"]
  :dev {:resource-paths "test/resource"}

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "resources/public/cljs-out" :target-path]
  :aot :all
  :jar-exclusions [#"(?:^|/).svn/.idea"]
  :jar-inclusions [#"(?:^|/)\.ebextensions"]

  )
