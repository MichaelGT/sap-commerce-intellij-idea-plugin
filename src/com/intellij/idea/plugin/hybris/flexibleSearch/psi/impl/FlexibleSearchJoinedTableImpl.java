// This is a generated file. Not intended for manual editing.
package com.intellij.idea.plugin.hybris.flexibleSearch.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.idea.plugin.hybris.flexibleSearch.psi.FlexibleSearchTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.idea.plugin.hybris.flexibleSearch.psi.*;

public class FlexibleSearchJoinedTableImpl extends ASTWrapperPsiElement implements FlexibleSearchJoinedTable {

  public FlexibleSearchJoinedTableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlexibleSearchVisitor visitor) {
    visitor.visitJoinedTable(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlexibleSearchVisitor) accept((FlexibleSearchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FlexibleSearchJoinSpecification getJoinSpecification() {
    return findNotNullChildByClass(FlexibleSearchJoinSpecification.class);
  }

  @Override
  @Nullable
  public FlexibleSearchJoinType getJoinType() {
    return findChildByClass(FlexibleSearchJoinType.class);
  }

  @Override
  @Nullable
  public FlexibleSearchJoinedTable getJoinedTable() {
    return findChildByClass(FlexibleSearchJoinedTable.class);
  }

  @Override
  @Nullable
  public FlexibleSearchTablePrimary getTablePrimary() {
    return findChildByClass(FlexibleSearchTablePrimary.class);
  }

  @Override
  @NotNull
  public FlexibleSearchTableReference getTableReference() {
    return findNotNullChildByClass(FlexibleSearchTableReference.class);
  }

}